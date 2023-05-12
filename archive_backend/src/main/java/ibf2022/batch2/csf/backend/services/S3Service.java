package ibf2022.batch2.csf.backend.services;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;


@Service
public class S3Service {

    @Autowired
    private AmazonS3 s3Client;

    @Value("${DO_STORAGE_BUCKETNAME}")
    private String bucketName;

    public String upload(String name, String title, String comments, MultipartFile file) throws IOException{

        Map<String, String> userData = new HashMap<>();
        userData.put("name", name);
        userData.put("title", title);
        userData.put("comments", comments);
        userData.put("file name", file.getOriginalFilename());
        
        
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
        metadata.setUserMetadata(userData);


        String bundleId = UUID.randomUUID().toString()
            .substring(0, 8);

    
       
        PutObjectRequest putRequest = 
            new PutObjectRequest(
                bucketName, "myobject%s.%s".formatted(bundleId)
                        , file.getInputStream(), metadata);
        putRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        s3Client.putObject(putRequest);
        return "myobject%s.%s".formatted(bundleId);

    }




    
}
