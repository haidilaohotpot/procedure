package cn.edu.mju.procedure.utils;

import cn.edu.mju.procedure.enums.BaseEnum;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/23
 */
public class EnumUtil {


    /**
     * 根据state获取对应的Enum对象
     * @param state 状态码
     * @param enumClazz 对应的Enum类型
     * @param <T>
     * @return
     */
    public static <T extends BaseEnum> T getEnumByState(int state, Class<T> enumClazz){

        for (T item : enumClazz.getEnumConstants()) {

            if(item.getState()==state){
                return item;
            }

        }
        return null;

    }


}
