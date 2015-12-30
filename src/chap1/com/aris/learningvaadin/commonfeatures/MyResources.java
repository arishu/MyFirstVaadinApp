package chap1.com.aris.learningvaadin.commonfeatures;

import java.util.ListResourceBundle;

public class MyResources extends  ListResourceBundle {
	protected Object[][] getContents() {
        return new Object[][] {
            // LOCALIZE THE SECOND STRING OF EACH ARRAY (e.g., "OK")
            {"OkKey", "是"},
            {"CancelKey", "取消"},
            // END OF MATERIAL TO LOCALIZE
       };
    }

}
