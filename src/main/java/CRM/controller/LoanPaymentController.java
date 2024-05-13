package CRM.controller;

import CRM.repository.UserRepository;
import CRM.domain.EmployeeEntity;
import CRM.domain.LoanEntity;
import CRM.domain.LoanPaymentEntity;
import CRM.domain.UserEntity;
import CRM.dto.LoanPaymentsSearchQuery;
import CRM.service.LoanPaymentService;
import CRM.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import jdk.incubator.vector.VectorOperators;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class LoanPaymentController {

    private final LoanPaymentService loanPaymentService;
    private final LoanService loanService;
    private final UserRepository userRepository;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<LoanEntity> add(@RequestBody LoanPaymentEntity loanPaymentEntity) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity currentUser = userRepository.findByUsername(authentication.getName());
        EmployeeEntity employee = currentUser.getEmployeeEntity();

        String author = employee.getFirstName() + " " + employee.getLastName();
        loanPaymentEntity.setAuthor(author);
        LoanEntity loan = loanService.get(loanPaymentEntity.getLoanId());


        if (loanPaymentEntity.getDeniedPayment()) {
            loanPaymentService.edit(loanPaymentEntity);
        } else {
            loanPaymentEntity = loanPaymentService.edit(loanPaymentEntity);
            loanPaymentService.edit(loanPaymentEntity);

            MathContext mc = new MathContext(10);

            BigDecimal paymentAmount = loanPaymentEntity.getAmount();
            BigDecimal oldAmount = loan.getAmount();


            BigDecimal newLoanAmount = oldAmount.subtract(paymentAmount, mc);

            if (newLoanAmount.compareTo(BigDecimal.ZERO) <= 0) {
                loan.setNullificationRequest(true);
                //ექსტრა გადახდილის დათვლა
                loan.setPaidExtra(paymentAmount.subtract(oldAmount));
                loan.setAmount(BigDecimal.valueOf(0));

            } else {
                loan.setAmount(newLoanAmount);
            }

            loanService.edit(loan);
        }

        return ResponseEntity.ok(loan);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @CrossOrigin
    public LoanPaymentEntity edit(@RequestBody LoanPaymentEntity loanPaymentEntity) {
        return loanPaymentService.edit(loanPaymentEntity);
    }

    @GetMapping("/get")
    @CrossOrigin
    public List<LoanPaymentEntity> add(@RequestParam Long loanId) {
        return loanPaymentService.list(loanId);
    }

    @GetMapping("/getPagedPayments")
    @CrossOrigin
    public LoanPaymentsSearchQuery page(Integer limit, Integer start,
                                        @RequestParam(required = false) String id,
                                        @RequestParam(required = false) String creditor,
                                        @RequestParam(required = false) String debtor,
                                        @RequestParam(required = false) String debtorIdentificator,
                                        @RequestParam(required = false) String assignedAgent,
                                        @RequestParam(required = false) Long amountStart,
                                        @RequestParam(required = false) Long amountEnd,
                                        @RequestParam(required = false) String dateStart,
                                        @RequestParam(required = false) String dateEnd,
                                        @RequestParam(required = false) Boolean withCheck) {
        return loanPaymentService.page(start, limit, id, creditor, debtor, debtorIdentificator, assignedAgent, amountStart, amountEnd, dateStart, dateEnd, withCheck);
    }


    @GetMapping("/getDeniedPayments")
    @CrossOrigin
    public List<LoanPaymentEntity> getDeniedPayments(@RequestParam Long loanId) {
        return loanPaymentService.deniedList(loanId);
    }


    @GetMapping("/delete")
    @CrossOrigin
    public ResponseEntity<LoanEntity> delete(@RequestParam Long id) {

        LoanPaymentEntity loanPaymentEntity = loanPaymentService.get(id);
        BigDecimal paymentAmount = loanPaymentEntity.getAmount();
        LoanEntity loan = loanService.get(loanPaymentEntity.getLoanId());
        BigDecimal oldAmount = loan.getAmount();
        MathContext mc = new MathContext(10);

        BigDecimal newLoanAmount = oldAmount.add(paymentAmount, mc);

        if (newLoanAmount.compareTo(BigDecimal.ZERO) >= 0) {
            loan.setNullified(false);
        }

        loan.setAmount(newLoanAmount);
        loanService.edit(loan);
        loanPaymentService.delete(id);

        return ResponseEntity.ok(loan);
    }

}

