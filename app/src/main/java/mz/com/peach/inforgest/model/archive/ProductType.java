package mz.com.peach.inforgest.model.archive;

/**
 * Created by peach on 12/27/14.
 */
public class ProductType {
    private Long _id;
    private String _description;

    public ProductType() {}

    public ProductType(Long _id, String _description) {
        super();
        this._id = _id;
        this._description = _description;
    }



    public Long getId() {
        return _id;
    }
    public void setId(Long _id) {
        this._id = _id;
    }
    public String getDescription() {
        return _description;
    }
    public void setDescription(String _description) {
        this._description = _description;
    }
}
