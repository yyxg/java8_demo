package demo.generic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xialihui
 * @param <T>
 */
@Slf4j
public class Generic<T>{
    /**
     *key这个成员变量的类型为T,T的类型由外部指定
     */
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void showKeyValue1(Generic<Number> obj){
        log.debug("泛型测试{}","key value is " + obj.getKey());
    }


    /**
     * 类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。
     * 此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
     * @param obj
     */
    public static void showKeyValue2(Generic<?> obj){
        log.debug("泛型测试{}","key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);


        // showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
        // cannot be applied to Generic<java.lang.Number>
        // showKeyValue(gInteger);

        //使用类型通配符则没有问题
         showKeyValue2(gInteger);



    }
}