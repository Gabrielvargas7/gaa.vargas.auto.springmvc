/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.services.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author gabriel
 */
public final class PasswordService
{

  private static PasswordService instance;

  private PasswordService()
  {
  }

  public synchronized String encrypt(String plaintext)
  {

    final StringBuilder sbMd5Hash = new StringBuilder();
    MessageDigest md = null;
    try
    {
    //  md = MessageDigest.getInstance("SHA"); //step 2
        md = MessageDigest.getInstance("MD5"); //step 2
    }
    catch(NoSuchAlgorithmException e)
    {
      e.getMessage();
    }

    try
    {
      md.update(plaintext.getBytes("UTF-8")); //step 3
    }
    catch(UnsupportedEncodingException e)
    {
      e.getMessage();
    }

    byte raw[] = md.digest(); //step 4

//    String hash = (new BASE64Encoder()).encode(raw); //step 5
//    return hash; //step 6

    for (byte element : raw)
    {
        sbMd5Hash.append(Character.forDigit((element >> 4) & 0xf, 16));
        sbMd5Hash.append(Character.forDigit(element & 0xf, 16));
    }

    return sbMd5Hash.toString();
 }
  
  public static synchronized PasswordService getInstance() //step 1
  {
    if(instance == null)
    {
      return new PasswordService();
    }
    else
    {
      return instance;
    }
  }


}
