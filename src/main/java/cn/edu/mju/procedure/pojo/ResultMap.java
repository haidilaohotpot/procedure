package cn.edu.mju.procedure.pojo;

public class ResultMap {
    private int code;
    private String msg;
    private Object data;
    private int state;

    public int getState() {
        return state;
    }

    public ResultMap setState(int state) {
        this.state = state;
        return this;
    }

    public ResultMap(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultMap(int code){
        this.code = code;
        this.msg = msg;
    }

    public static ResultMap SUCCESS(){
        ResultMap resultMap = new ResultMap(200,"操作成功");
        return resultMap;
    }

    public static ResultMap FAIL(String msg){
        ResultMap resultMap = new ResultMap(500,msg);
        return resultMap;
    }

    public int getCode() {
        return code;
    }

    public ResultMap setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultMap setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultMap setData(Object data) {
        this.data = data;
        return this;
    }
}
