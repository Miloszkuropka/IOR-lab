package goodies;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


/**
 *
 * @author
 */
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Character>{

    @Override
    public Character convertToDatabaseColumn(Boolean attrib) {
        if (attrib != null) {
            if (attrib) {
                return 'Y';
            } else {
                return 'N';
            }
        }
        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(Character attrib) {
        if (attrib != null) {
            return attrib.equals('Y');
        }
        return null;
    }
   
    
}
