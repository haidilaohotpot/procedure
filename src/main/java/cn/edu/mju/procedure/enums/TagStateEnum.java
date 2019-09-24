package cn.edu.mju.procedure.enums;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/23
 */
public enum TagStateEnum implements BaseEnum{

    SUCCESS(0, "操作成功"), FAIL(-1001, "操作失败"), EMPTY(-1002, "标签为空");

    private int state;

    private String stateInfo;

    TagStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }


    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getStateInfo() {
        return stateInfo;
    }


}
