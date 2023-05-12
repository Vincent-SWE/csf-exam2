package ibf2022.batch2.csf.backend.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.batch2.csf.backend.models.Post;
import ibf2022.batch2.csf.backend.services.ArchiveService;
import ibf2022.batch2.csf.backend.services.FileUploadService;
import ibf2022.batch2.csf.backend.services.S3Service;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@RestController
public class UploadController {

	@Autowired
    private S3Service s3Svc;

	@Autowired
	private FileUploadService fupSvc;

	// @Autowired
	// private ArchiveRepository arcRepo;

	@Autowired
	private ArchiveService arcSvc;


	// TODO: Task 2, Task 3, Task 4
	@PostMapping(path="/upload", 
		consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<String> upload( 
				@RequestPart String name,
				@RequestPart String title,
				@RequestPart String comments,
				@RequestPart MultipartFile file)
				{
					String key = "";

					try{
						key = s3Svc.upload(name, title, comments, file);
						this.fupSvc.upload(name, title, comments, file);

					} catch( IOException | SQLException e ) {
						return ResponseEntity
							.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body(e.getMessage());
					}

					JsonObject payload = Json.createObjectBuilder()
						.add("bundleId", key)
						.build();
						
					return ResponseEntity.ok(payload.toString());
				

			if(s3Svc.putRequest.isCreated()) {
				Object recordBundle = new Object();
				return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(s3Svc.bundleId.getValue());
			} else {
				String errorMsg = "Error Message";
				return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(errorMsg);
			}
				
		}

	// TODO: Task 5
	@GetMapping(path="/bundle/{bundleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<String> getBundle(@PathVariable String bundleId) {
		Object obj = arcSvc.getBundleByBundleId(bundleId);
		if (((MultipartFile) obj).isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing found");
		else {
			return ResponseEntity.ok(obj.toString());
		}
	}


	// TODO: Task 6
	@GetMapping(path="/bundles", consumes = MediaType.APPLICATION_JSON_VALUE) 
	@ResponseBody
	public ResponseEntity<String> getBundles() {

		JsonArray result = null;
        Object arr = this.arcSvc.getBundles();
        Object aa = arr.get();

        JsonArrayBuilder arrBld = Json.createArrayBuilder();
        for(Post c: aa)
            arrBld.add(c.toJSON());
        result = arrBld.build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
	}







}