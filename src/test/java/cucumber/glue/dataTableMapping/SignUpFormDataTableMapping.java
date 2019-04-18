package cucumber.glue.dataTableMapping;

import io.cucumber.datatable.DataTable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignUpFormDataTableMapping {

    private Map<String, String> dataMap;

    public Map get(){
        return dataMap;
    }

    public Map writeDataToMap(DataTable data){
        dataMap = data.asMap(String.class, String.class);
        return dataMap;
    }
}
