package gaa.vargas.autodealer.services.file;

import gaa.vargas.autodealer.services.filter.FileListFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class PictureNamingUpload {

		
		

	public static void savePictures(List pictureList, int autoid, String path) {
		// TODO Auto-generated method stub
		
			String autoidString = Integer.toString(autoid);
		   	Iterator itrPictures = pictureList.iterator();

	          // get the number of files
	                int r = 0;
	                List<String> pictures = new ArrayList<String>();
	                File dir = new File(path);

	                FilenameFilter select = (FilenameFilter) new FileListFilter(autoidString,"jpg");
	                String[] children = dir.list(select);
	                if (children == null)
	                {
	                    r = 0;
	                } else {

	                    r=children.length;
	                }

	          while (itrPictures.hasNext())
	          {
	            r++;
	            FileItem item = (FileItem) itrPictures.next();
/*
	            if (item.isFormField())
	            {
	              String name = item.getFieldName();
	              String value = item.getString();
	      
	            }
	            
*/	            
	            if (item.getFieldName().equals("mainpicture"))
	            {
	                try {
                        String itemName = item.getName();
                        int IndexOf = itemName.indexOf(".");
                        String domainName = itemName.substring(IndexOf);
                        String finalimage = autoidString+"_main"+domainName;
                        File savedFile = new File(path+finalimage);
                        item.write(savedFile);

                  } catch (Exception e) {
                    e.printStackTrace();
                  }
	         
	            }
	            else
	            {
	                  try {
	                        String itemName = item.getName();
	                        int IndexOf = itemName.indexOf(".");
	                        String domainName = itemName.substring(IndexOf);
	                        String finalimage = autoidString+"_"+r+domainName;
	                        File savedFile = new File(path+finalimage);
	                        item.write(savedFile);

	                  } catch (Exception e) {
	                    e.printStackTrace();
	                  }
	            }
	          }
	}


	public static void saveMainPicture(List pictureList, int autoid, String path) {
		// TODO Auto-generated method stub
	
		String autoidString = Integer.toString(autoid);
	   	Iterator itrPictures = pictureList.iterator();

          // get the number of files
                int r = 0;
                List<String> pictures = new ArrayList<String>();
                File dir = new File(path);

                FilenameFilter select = (FilenameFilter) new FileListFilter(autoidString,"jpg");
                String[] children = dir.list(select);
                if (children == null)
                {
                    r = 0;
                } else {

                    r=children.length;
                }

          while (itrPictures.hasNext())
          {
            r++;
            FileItem item = (FileItem) itrPictures.next();

            if (item.isFormField())
            {
              String name = item.getFieldName();
              String value = item.getString();
      
            }
              else
            {
                  try {
                        String itemName = item.getName();
                        int IndexOf = itemName.indexOf(".");
                        String domainName = itemName.substring(IndexOf);
                        String finalimage = autoidString+"_Main"+domainName;
                        File savedFile = new File(path+finalimage);
                        item.write(savedFile);

                  } catch (Exception e) {
                    e.printStackTrace();
                    }
            }
          }

		
	}
	

	
}
