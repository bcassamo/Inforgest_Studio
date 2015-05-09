package mz.com.peach.inforgest.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mz.com.peach.inforgest.helper.DatabaseHelper;
import mz.com.peach.inforgest.model.archive.ProductFamily;
import mz.com.peach.inforgest.model.archive.ProductGroup;
import mz.com.peach.inforgest.model.archive.ProductType;

/**
 * Created by peach on 12/27/14.
 */
public class InforgestDAO {
    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public InforgestDAO(Context context) {
        helper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDb() {
        if (db == null) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    public void close() {
        helper.close();
    }

    // Crud for Product
    /*public List<Product> listProduct() {
        Cursor cursor = getDb().query(DatabaseHelper.Product.TABLE_PRODUCT,
                DatabaseHelper.Product.COLUMNS, null, null, null, null, null);
        List<Product> products = new ArrayList<Product>();
        while(cursor.moveToNext()){
            Product product = makeProduct(cursor);
            products.add(product);
        }

        cursor.close();
        return products;
    }*/

    /*private Product makeProduct(Cursor cursor) {
        Product product = new Product(
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_ID)),
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_FAMILY)),
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_GROUP)),
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_TYPE)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Product.COLUMN_DESCRIPTION))
        );
        return product;
    }*/

    /*public Product getProductById(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.Product.TABLE_PRODUCT, DatabaseHelper.Product.COLUMNS, DatabaseHelper.Product.COLUMN_ID + " = ?", new String[]{id.toString()}, null, null, null);
        if(cursor.moveToNext()){
            Product product = makeProduct(cursor);
            cursor.close();
            return product;
        }

        return null;
    }*/

    /*public long saveProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Product.COLUMN_FAMILY, product.getFamilyId());
        values.put(DatabaseHelper.Product.COLUMN_GROUP, product.getGroupId());
        values.put(DatabaseHelper.Product.COLUMN_TYPE, product.getTypeId());
        values.put(DatabaseHelper.Product.COLUMN_DESCRIPTION, product.getDescription());

        return getDb().insert(DatabaseHelper.Product.TABLE_PRODUCT, null, values);
    }*/

    /*public long updateProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Product.COLUMN_FAMILY, product.getFamilyId());
        values.put(DatabaseHelper.Product.COLUMN_GROUP, product.getGroupId());
        values.put(DatabaseHelper.Product.COLUMN_TYPE, product.getTypeId());
        values.put(DatabaseHelper.Product.COLUMN_DESCRIPTION, product.getDescription());

        return getDb().update(DatabaseHelper.Product.TABLE_PRODUCT, values, DatabaseHelper.Product.COLUMN_ID + " = ?", new String[]{ product.getId().toString() });
    }*/

    /*public boolean deleteProduct(Long id){
        String whereClause = DatabaseHelper.Product.COLUMN_ID + " = ?";
        String[] whereArgs = new String[]{ id.toString() };
        int deleted = getDb().delete(DatabaseHelper.Product.TABLE_PRODUCT, whereClause, whereArgs);

        return deleted > 0;
    }*/

    // End Crud for Product



    // Crud for ProductFamily
    public List<ProductFamily> listProductFamily() {
        List<ProductFamily> productFamilys = new ArrayList<ProductFamily>();
        db = helper.getReadableDatabase();

        Cursor cursor = getDb().query(DatabaseHelper.ProductFamily.TABLE_PRODUCT_FAMILY,
                DatabaseHelper.ProductFamily.COLUMNS, null, null, null, null, null);

        while(cursor.moveToNext()){
            ProductFamily productFamily = makeProductFamily(cursor);
            productFamilys.add(productFamily);
        }

        cursor.close();
        return productFamilys;
    }

    private ProductFamily makeProductFamily(Cursor cursor) {
        ProductFamily productFamily = new ProductFamily(
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.ProductFamily.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.ProductFamily.COLUMN_DESCRIPTION))
        );
        return productFamily;
    }

    public ProductFamily getProductFamilyById(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.ProductFamily.COLUMN_ID, DatabaseHelper.ProductFamily.COLUMNS, DatabaseHelper.ProductFamily.COLUMN_ID + " = ?", new String[]{id.toString()}, null, null, null);
        if(cursor.moveToNext()){
            ProductFamily productFamily = makeProductFamily(cursor);
            cursor.close();
            return productFamily;
        }

        return null;
    }

    public long saveProductFamily(ProductFamily productFamily){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.ProductFamily.COLUMN_DESCRIPTION, productFamily.getDescription());

        return getDb().insert(DatabaseHelper.ProductFamily.TABLE_PRODUCT_FAMILY, null, values);
    }

    public long updateProductFamily(ProductFamily productFamily){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.ProductFamily.COLUMN_DESCRIPTION, productFamily.getDescription());

        return getDb().update(DatabaseHelper.ProductFamily.TABLE_PRODUCT_FAMILY, values, DatabaseHelper.ProductFamily.COLUMN_ID + " = ?", new String[]{ productFamily.getId().toString() });
    }

    public boolean deleteProductFamily(Long id){
        String whereClause = DatabaseHelper.ProductFamily.COLUMN_ID + " = ?";
        String[] whereArgs = new String[]{ id.toString() };
        int deleted = getDb().delete(DatabaseHelper.ProductFamily.TABLE_PRODUCT_FAMILY, whereClause, whereArgs);

        return deleted > 0;
    }
    // End Crud for ProductFamily


    // Crud for ProductGroup

    public List<ProductGroup> listProductGroup() {
        List<ProductGroup> productGroups = new ArrayList<ProductGroup>();
        db = helper.getReadableDatabase();

        Cursor cursor = getDb().query(DatabaseHelper.ProductGroup.TABLE_PRODUCT_GRUOUP,
                DatabaseHelper.ProductGroup.COLUMNS, null, null, null, null, null);

        while(cursor.moveToNext()){
            ProductGroup productGroup = makeproductGroup(cursor);
            productGroups.add(productGroup);
        }

        cursor.close();
        return productGroups;
    }


    private ProductGroup makeproductGroup(Cursor cursor) {
        ProductGroup productGroup = new ProductGroup(
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.ProductGroup.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.ProductGroup.COLUMN_DESCRIPTION))
        );
        return productGroup;
    }


    public long saveProductGroup(ProductGroup productGroup){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.ProductGroup.COLUMN_DESCRIPTION, productGroup.getDescription());

        return getDb().insert(DatabaseHelper.ProductGroup.TABLE_PRODUCT_GRUOUP, null, values);
    }

    // End Crud for ProductGroup


    // Crud for ProductType

    public List<ProductType> listProductType() {
        List<ProductType> productTypes = new ArrayList<ProductType>();
        db = helper.getReadableDatabase();

        Cursor cursor = getDb().query(DatabaseHelper.ProductType.TABLE_PRODUCT_TYPE,
                DatabaseHelper.ProductType.COLUMNS, null, null, null, null, null);

        while(cursor.moveToNext()){
            ProductType productType = makeproductType(cursor);
            productTypes.add(productType);
        }

        cursor.close();
        return productTypes;
    }


    private ProductType makeproductType(Cursor cursor) {
        ProductType productType = new ProductType(
                cursor.getLong(cursor.getColumnIndex(DatabaseHelper.ProductType.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.ProductType.COLUMN_DESCRIPTION))
        );
        return productType;
    }

    public ProductType getProductTypeById(Long id){
        Cursor cursor = getDb().query(DatabaseHelper.ProductType.TABLE_PRODUCT_TYPE, DatabaseHelper.ProductType.COLUMNS, DatabaseHelper.ProductType.COLUMN_ID + " = ?", new String[]{id.toString()}, null, null, null);
        if(cursor.moveToNext()){
            ProductType productType = makeproductType(cursor);
            cursor.close();
            return productType;
        }

        return null;
    }

    public long saveProductType(ProductType productType){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.ProductType.COLUMN_DESCRIPTION, productType.getDescription());

        return getDb().insert(DatabaseHelper.ProductType.TABLE_PRODUCT_TYPE, null, values);
    }

    public long updateProductType(ProductType productType){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.ProductFamily.COLUMN_DESCRIPTION, productType.getDescription());

        return getDb().update(DatabaseHelper.ProductType.TABLE_PRODUCT_TYPE, values, DatabaseHelper.ProductType.COLUMN_ID + " = ?", new String[]{ productType.getId().toString() });
    }

    public boolean deleteProductType(Long id){
        String whereClause = DatabaseHelper.ProductType.COLUMN_ID + " = ?";
        String[] whereArgs = new String[]{ id.toString() };
        int deleted = getDb().delete(DatabaseHelper.ProductType.TABLE_PRODUCT_TYPE, whereClause, whereArgs);

        return deleted > 0;
    }

    // End Crud for ProductType
}
