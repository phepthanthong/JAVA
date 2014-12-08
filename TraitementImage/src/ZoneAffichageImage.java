import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.util.*;

/**
 * @author Hieu
 * Cette classe représente une zone dans la fenêtre principale 
 * òu se place les images ouvertes par utilisateur présentées sous forme d'une liste d'images
 * (Affichage d'une ou plusieurs images)
 */
public class ZoneAffichageImage extends JPanel {


	/**
	 * Constructeur par défaut ZoneAffichageImage
	 */
	public ZoneAffichageImage() {

		setSize(new Dimension(500,500));
		setBorder(new LineBorder(Color.black));
		
		
		/*private String getImageFile() {
	    JFileChooser fc = new JFileChooser();	    
	    int result = fc.showOpenDialog(null);
	    File file = null;
	    if (result == JFileChooser.APPROVE_OPTION) {
	      file = fc.getSelectedFile();
	      return file.getPath();
	    } else
	      return null;
	  }*/



	}
}
