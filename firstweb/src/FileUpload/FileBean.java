package FileUpload;

/**
 * 用于存储上传文件信息
 */
public class FileBean {
    private int id;
    private String name;
    private String size;
    private String type;
    // 上传时间
    private String addTime;
    private String file_path;
    private String info;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAddTime() {
        return addTime;
    }
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public String toString() {
        return "文件名 "+name;
    }
}
