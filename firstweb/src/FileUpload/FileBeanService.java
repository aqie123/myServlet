package FileUpload;

import java.util.List;

public class FileBeanService {
    private FileBeanDao dao  = new FileBeanDao();
    public void saveFileBean(FileBean bean){
        dao.saveFile(bean);
    }

    public FileBean findById(int id){
        return dao.findByID(id);
    }

    public List<FileBean> findAll(){
        return dao.findAll();
    }
}
