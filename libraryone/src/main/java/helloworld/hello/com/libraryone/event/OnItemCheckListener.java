package helloworld.hello.com.libraryone.event;


import helloworld.hello.com.libraryone.entity.Photo;

public interface OnItemCheckListener {

    /***
     * @param position          所选图片的位置
     * @param path              所选的图片
     * @param isCheck           当前状态
     * @param selectedItemCount 已选数量
     * @return enable check
     */
    boolean OnItemCheck(int position, Photo path, boolean isCheck, int selectedItemCount);

}
