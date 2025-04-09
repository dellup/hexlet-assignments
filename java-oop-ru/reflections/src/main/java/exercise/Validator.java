package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Object o) {
        List<String> res = new ArrayList<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(o) == null) {
                        res.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
    public static Map<String, List<String>> advancedValidate(Object o) {
        Map<String, List<String>> res = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            List<String> list = new ArrayList<>();
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(o) == null) {
                        list.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                try {
                    MinLength annotation = field.getAnnotation(MinLength.class);
                    if (field.get(o) != null) {
                        if (field.get(o).toString().length() < annotation.minLength()) {
                            list.add("length less than " + annotation.minLength());
                        }
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (!list.isEmpty()) {
                res.put(field.getName(), list);
            }
        }
        return res;
    }
}
// END
