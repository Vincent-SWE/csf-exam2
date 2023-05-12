package ibf2022.batch2.csf.backend.repositories;

import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.batch2.csf.backend.models.Post;

@Repository
public class ArchiveRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	//TODO: Task 4
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	//db.archives.insertOne({
	//   bundleId: "bundleId",
	//   date: "2023-05-12",
	//   title: "title",
	//   name: "name",
	//   comments: "comments",
	//   urls: [
	//     "url of image 1",
	//     "url of image 2",
	//     "url of image 3",
	//     "url of image 4"
	//     ]
	// });
	public Object recordBundle(String name, String title, String comments, MultipartFile file) {
		return new Object();
	}

	//TODO: Task 5
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	//
	// db.archives.find({ bundleId: "11111111" })
	public Object getBundleByBundleId(String bundleId) {

			Criteria c = Criteria.where("bundleId").is(bundleId);

			Query q = Query.query(c);
	
			Document d = mongoTemplate.findOne(q, Document.class, "archives");
			
			Post post = Post.create(d);
			if (null == post)
				return Optional.empty();

			return Optional.of(post);

		}



	//TODO: Task 6
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	// db.archives.find({})
	public Object getBundles() {
		return mongoTemplate.findDistinct(new Query(), "bundleId", "archives", String.class);
	}


}
