package com.Nikolovska.spring.HRManagement.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.model.FileDB;
import com.Nikolovska.spring.HRManagement.model.ResponseFile;
import com.Nikolovska.spring.HRManagement.service.EmployeeService;
import com.Nikolovska.spring.HRManagement.service.FileStorageService;


@Controller
public class FileController {

  @Autowired
  private FileStorageService storageService;
  
  @Autowired
  private EmployeeService employeeService;
  
	@RequestMapping(path = "/upload", method = RequestMethod.GET)
	public String getFiles(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employee", employees);
		return "upload";
	}
  
  
  @RequestMapping(path = "/upload", method = RequestMethod.POST)
  public String uploadFile(@ModelAttribute FileDB files, MultipartFile file, Model model) {
	  
    try {
    	if (!file.getOriginalFilename().equals("")) {
      storageService.store(file, files.getEmployee_id());
      return "redirect:/menu";
      } else { 
    	  model.addAttribute("errorMessage", "Please upload file!");
    	  return "upload";
      }
		
    } catch (Exception e){
		model.addAttribute("errorMessage", "Please upload file!");
		return "redirect:/upload";
	}
  }


  
  @RequestMapping(path = "/listfiles", method = RequestMethod.GET)
  public String getListFiles(Model model) {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/listfiles/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length,
          dbFile.getEmployee_id());
    }).collect(Collectors.toList());

    model.addAttribute("files", files);
    	return "listfiles";
  }

  @GetMapping("/listfiles/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
}
