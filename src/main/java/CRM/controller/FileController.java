//package CRM.controller;
//
//import CRM.service.FileReaderService;
//import CRM.service.FileService;
//import CRM.service.LeadService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("file")
//@RequiredArgsConstructor
//@Slf4j
//public class FileController {
//
//    @Autowired
//    private HttpServletRequest request;
//    private final FileService fileService;
//    //    private final AttachedFileService attachedFileService;
//    private final LeadService leadService;
//
//    private final FileReaderService fileReaderService;
//
//    @GetMapping("check")
//    public ResponseEntity<String> check() {
//        String filename = "test.xlsx";
//        File file = fileReaderService.readFile(filename);
//        return ResponseEntity.ok("checked");
//    }
//
//    @GetMapping("upload/list")
//    @CrossOrigin
//    public ResponseEntity<List<String>> uploadFileList() {
//        List<String> fileNames = fileService.getUploadedFileNames();
//        return ResponseEntity.ok(fileNames);
//    }
//
//    @PostMapping("example")
//    public ResponseEntity<String> example(@RequestParam("filename") String filename) {
//        File file = fileReaderService.readFile(filename);
//        return ResponseEntity.ok("grafikebi.xlsx file read!");
//    }
//
//   @PostMapping(value = "upload/loanfile", consumes = "multipart/form-data")
//   @CrossOrigin
//   public ResponseEntity<List<AttachedFileEntity>> uploadFile(@RequestParam("file") MultipartFile multipartFile,
//                                                              @RequestParam("id") Long id,
//                                                              @RequestParam("name") String name) {
//
//       fileService.uploadFile(multipartFile, id, name);
//       LoanEntity loanEntity;
//       loanEntity = loanService.get(id);
//       return null;
//   }
//
//    @GetMapping("read")
//    public ResponseEntity<String> readFileFromResource(@RequestParam String filename) {
//
//        fileService.readFileFromResource(filename);
//        return ResponseEntity.ok("read!");
//    }
//
//    @RequestMapping(path = "/download/loanAttachment", method = RequestMethod.GET)
//    public ResponseEntity<Resource> get(@RequestParam Long id) {
//
//
//        AttachedFileEntity file = attachedFileService.get(id);
//
//        Resource resource = fileService.downloadLoanAttachment(file.getOriginalFileName());
//
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            System.out.println("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        HttpHeaders header = new HttpHeaders();
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//
//        return null;
//    }
//
//    @RequestMapping(path = "/download/oldLoanAttachment", method = RequestMethod.GET)
//    public ResponseEntity<Resource> get(@RequestParam String filename) {
//
//
//        Resource resource = fileService.downloadLoanAttachment(filename);
//
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            System.out.println("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        HttpHeaders header = new HttpHeaders();
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
//
//
//    @GetMapping("/loan/get")
//    @CrossOrigin
//    public List<AttachedFileEntity> add(@RequestParam Long loanId) {
//        return attachedFileService.list(loanId);
//    }
//
//    @GetMapping("/loan/delete")
//    @CrossOrigin
//    public ResponseEntity<String> delete(@RequestParam Long fileId) {
//
//
//        attachedFileService.delete(fileId);
//
//        return ResponseEntity.ok("successfully deleted");
//
//    }
//
//
//}
