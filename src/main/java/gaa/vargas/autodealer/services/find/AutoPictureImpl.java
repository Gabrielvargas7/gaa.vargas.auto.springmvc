/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.find;

 import gaa.vargas.autodealer.services.filter.FileListFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class AutoPictureImpl implements AutoPicture
{

    public String findMainPicture(int autoid,String path)
    {
        String picture ="";
        String startWith = String.valueOf(autoid)+"_main";
        File dir = new File(path);
        FilenameFilter select = (FilenameFilter) new FileListFilter(startWith,"jpg");
        String[] children = dir.list(select);
        if (children != null)
        {
            if(children.length != 0)
                picture =  children[0];
        }
        return picture;
    }


    public List<String> findAllPicture(int autoid,String path)
    {

        List<String> pictures = new ArrayList<String>();
        String startWith = String.valueOf(autoid)+"_";

        File dir = new File(path);
        FilenameFilter select = (FilenameFilter) new FileListFilter(startWith,"jpg");
        String[] children = dir.list(select);
        if (children == null)
        {
            pictures.add("");
        } else {
            for (int i=0; i<children.length; i++)
            {
                // Get filename of file or directory
                pictures.add(children[i]);
            }
        }
        return pictures;
    }

}
