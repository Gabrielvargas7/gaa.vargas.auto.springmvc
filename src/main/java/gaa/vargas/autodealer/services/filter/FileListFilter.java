/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author gabriel
 */
public class FileListFilter  implements FilenameFilter{

     private String startwith;
     private String extension;

  public FileListFilter(String startwith, String extension) {
      this.startwith = startwith;
      this.extension = "."+extension;
  }

    public boolean accept(File file, String string)
    {
        return string.startsWith(startwith);
    }
}
