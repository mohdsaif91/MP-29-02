/*
 * 
 * CopyRight cosmos
 */
package com.mycompany.mp2;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author saif
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class updateImageProduct extends HttpServlet {

    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    String imagename;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset+UTF-8");
            System.out.println("KING KONG");
            String companyname = request.getParameter("companyname");
            String ogcompany = companyname.replace(" ", "");
            String bradname = request.getParameter("brandname");
            String query = "select imagename from " + companyname + " where brandname='" + bradname + "'";
            System.out.println(query);
            con = ConnectionClass.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                imagename = rs.getString("imagename");
            } else {
                imagename = null;
            }
            con.close();
            Part part = request.getPart("imagenamepro");
            String partimagename = getImmagename(part);
            InputStream IS = part.getInputStream();
            System.out.println("Image name " + imagename + " partname " + partimagename);
            DeleteImageinAmazon(IS, partimagename);
            UploadImage(IS, partimagename);
            UpdateImagename(partimagename, ogcompany, bradname);
        } catch (SQLException ex) {
            Logger.getLogger(updateImageProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void DeleteImageinAmazon(InputStream IS, String keyName) {
        Thread th = new Thread(() -> {
            String accessKey = "AKIAZKNN4X5ZEQEH5QSV";
            String secretKey = "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";
            String bucketname = "matrixpharamacy9167";
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
            String amazonFileUploadLocationOriginal = bucketname + "/";
            AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(Regions.US_EAST_1)
                    .build();

            s3client.deleteObject(new DeleteObjectRequest(bucketname, keyName));
            System.out.println("Deleted !");
//            ObjectMetadata om = new ObjectMetadata();
//            PutObjectRequest por = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, IS, om)
//                    .withCannedAcl(CannedAccessControlList.PublicRead);
//            PutObjectResult obr = s3client.putObject(por);
//            System.out.println("Etag:" + obr.getETag() + "-->" + obr);
        });
        th.start();
    }

    private String getImmagename(Part part) {
        String contentDisp = null;
        contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private void UploadImage(InputStream IS, String keyName) {
        Thread th = new Thread(() -> {
            String accessKey = "AKIAZKNN4X5ZEQEH5QSV";
            String secretKey = "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";
            String bucketname = "matrixpharamacy9167";
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
            String amazonFileUploadLocationOriginal = bucketname + "/";
            AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(Regions.US_EAST_1)
                    .build();
            ObjectMetadata om = new ObjectMetadata();
            PutObjectRequest por = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, IS, om)
                    .withCannedAcl(CannedAccessControlList.PublicRead);
            PutObjectResult obr = s3client.putObject(por);
            System.out.println("Etag:" + obr.getETag() + "-->" + obr);
        });
        th.start();

    }

    private void UpdateImagename(String partimagename, String ogname, String brandname) {
        Thread th = new Thread(() -> {
            try {
                String query = "update " + ogname + " set imagename='" + partimagename + "' where brandname='" + brandname + "'";
                System.out.println(query);
                con = ConnectionClass.getConnection();
                ps = con.prepareStatement(query);
                ps.executeUpdate();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(updateImageProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        th.start();
    }

}
