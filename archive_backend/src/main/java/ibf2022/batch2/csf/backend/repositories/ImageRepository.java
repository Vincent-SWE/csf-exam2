package ibf2022.batch2.csf.backend.repositories;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.multipart.MultipartFile;

public class ImageRepository {

	@Autowired
	private DataSource dataSource;

	@Autowired
	MongoTemplate mongoTemplate;

	//TODO: Task 3
	// You are free to change the parameter and the return type
	// Do not change the method's name
	public Object upload(String name, String title, String comments, MultipartFile file) throws SQLException, IOException {
		return this.mongoTemplate.insert(name, title, comments, file, "archives");
	}





}
