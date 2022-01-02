package util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;


import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * @author HelithaSri
 * @created 1/2/2022 - 9:40 PM
 * @project HibernateCW
 */
public class Validation {
    public static Object validate(LinkedHashMap<JFXTextField, Pattern> map, JFXButton btn) {
        for (JFXTextField textFieldKey:map.keySet()) {
            Pattern patternValue = map.get(textFieldKey);
            if (!patternValue.matcher(textFieldKey.getText()).matches()) {
                if (! textFieldKey.getText().isEmpty()) {
                    textFieldKey.setStyle("-jfx-focus-color: red;-fx-text-fill: red");

//                    textFieldKey.setStyle("-fx-background-color: red");
                }
                return textFieldKey;
            }
            textFieldKey.setStyle("-fx-text-fill:Black");
        }
        btn.setDisable(false);
        return true;
    }
}
