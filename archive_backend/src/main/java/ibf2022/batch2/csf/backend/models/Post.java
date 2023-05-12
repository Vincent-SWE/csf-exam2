package ibf2022.batch2.csf.backend.models;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.zip.ZipFile;

import org.bson.Document;

public class Post implements Serializable {

    private String name;
    private String title;
    private String comments;
    private ZipFile file;


    public String getName() {
        return name;
    
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ZipFile getFile() {
        return file;
    }
    public void setFile(ZipFile file) {
        this.file = file;
    }
    

    
    public static Post populate(ResultSet rs) throws SQLException{
        final Post p = new Post();
        p.setName(rs.getString("name"));
        p.setTitle(rs.getString("title"));
        p.setComments(rs.getString("comments"));
        return p;
    }
    public static Post create(Document d) {
        return null;
    }


    

    
}
