package cn.edu.mju.procedure.exception;

import cn.edu.mju.procedure.enums.TagStateEnum;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/23
 */
public class TagOperationException extends RuntimeException {


    public TagOperationException(TagStateEnum stateEnum) {
        super(stateEnum.getStateInfo());
    }

    public TagOperationException(String message) {
        super(message);
    }
}
