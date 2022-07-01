package uz.zako.trainingmanagementsystem.Result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    private boolean success;
    private String message;
    private Object data;

    public Result(){

    }

    public Result(boolean success,String message,Object data){
        this.success = success;
        this.message = message;
        this.data = data;
    }


    public static Result ok(Object data,String message){
        return  new Result(true,message,data);
    };
    public static Result error(String message){
        return new Result(false,message,null);
    }
}
