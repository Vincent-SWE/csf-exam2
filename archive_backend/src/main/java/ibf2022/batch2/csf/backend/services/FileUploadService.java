package ibf2022.batch2.csf.backend.services;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.batch2.csf.backend.repositories.ImageRepository;

@Service
public class FileUploadService {
    
    @Autowired
    private ImageRepository imgRepo;

    public void upload(String name, String title, String comments, MultipartFile file) throws SQLException, IOException{
        this.imgRepo.upload(name, title, comments, file);
    }

}
