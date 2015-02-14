package com.rajib.SmartKart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/*
 * All the database related operations are done through this class
 */

public class BookTableOperations {

	// Database fields
	private SQLiteDatabase database;
	private SqlLiteHelper dbHelper;

	String[][] results;
	String loaddata = "Y";

	public BookTableOperations(Context context) {
		dbHelper = new SqlLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public void DeleteAllRows() {
		try {
			database.beginTransaction();
			database.delete(SqlLiteHelper.TABLE_BOOKS, null, null);
			database.delete(SqlLiteHelper.TABLE_VERSION, null, null);
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}
	}

	public String createbookrow(String[] column, byte[] img) {
		try {
			database.beginTransaction();
			ContentValues values = new ContentValues();
			values.put(SqlLiteHelper.COLUMN_BOOKID, column[0].toString());
			values.put(SqlLiteHelper.COLUMN_BOOKNAME, column[1].toString());
			values.put(SqlLiteHelper.COLUMN_BOOKAUTHOR, column[2].toString());
			values.put(SqlLiteHelper.COLUMN_ISBN, column[3].toString());
			values.put(SqlLiteHelper.COLUMN_PRICE, column[4]);
			values.put(SqlLiteHelper.COLUMN_IMAGE, img);
			database.insert(SqlLiteHelper.TABLE_BOOKS, null, values);
			database.setTransactionSuccessful();
			return "success";
		} catch (Exception e) {

			return e.toString();
		} finally {
			database.endTransaction();
		}

	}

	public int getCount() {
		String count = "SELECT count(*) FROM " + SqlLiteHelper.TABLE_BOOKS;
		Cursor countcur = database.rawQuery(count, null);
		countcur.moveToFirst();
		int icount = countcur.getInt(0);

		return icount;
	}

	public String retrieveversion(String verid) {

		/*
		 * this determines whether books need to be re-loaded in the sqllite
		 * database
		 */
		String vercount = "SELECT count(*) FROM " + SqlLiteHelper.TABLE_VERSION;
		Cursor vercountcur = database.rawQuery(vercount, null);
		vercountcur.moveToFirst();
		int icountver = vercountcur.getInt(0);

		if (icountver < 1) {
			try {
				database.beginTransaction();
				ContentValues vervalues = new ContentValues();
				vervalues.put(SqlLiteHelper.COLUMN_VERSION, verid);
				database.insert(SqlLiteHelper.TABLE_VERSION, null, vervalues);
				database.setTransactionSuccessful();
				loaddata = "Y";
				return loaddata;
			} finally {
				database.endTransaction();
			}

		}

		Cursor verCursor = database.query(SqlLiteHelper.TABLE_VERSION,
				new String[] { SqlLiteHelper.COLUMN_VERSION }, null, null,
				null, null, null, null);

		if (verCursor.moveToFirst()) {
			do {
				String versionid = verCursor.getString(verCursor
						.getColumnIndex(SqlLiteHelper.COLUMN_VERSION));
				if (versionid.contains(verid)) {
					loaddata = "N";
					return loaddata;
				}

			} while (verCursor.moveToNext());
		}

		return loaddata;
	}

	public byte[] retrieveimage(String bookid) {
		Cursor imgCursor = database.query(SqlLiteHelper.TABLE_BOOKS,
				new String[] { SqlLiteHelper.COLUMN_IMAGE },
				SqlLiteHelper.COLUMN_BOOKID + "=?", new String[] { bookid },
				null, null, null, null);
		byte[] image = null;
		if (imgCursor.moveToFirst()) {
			do {
				image = imgCursor.getBlob(imgCursor
						.getColumnIndex(SqlLiteHelper.COLUMN_IMAGE));
			} while (imgCursor.moveToNext());
		}

		return image;
	}

	public String[][] retrievebooks() {
		try {

			int j = getCount();

			results = new String[j][6];

			int i = 0;

			Cursor mCursor = database.query(SqlLiteHelper.TABLE_BOOKS, null,
					null, null, null, null, null, null);
			if (mCursor.moveToFirst()) {
				do {
					System.out.println("Rajib in bookop" + i);
					results[i][0] = mCursor.getString(mCursor
							.getColumnIndex(SqlLiteHelper.COLUMN_BOOKID));
					results[i][1] = mCursor.getString(mCursor
							.getColumnIndex(SqlLiteHelper.COLUMN_BOOKNAME));
					results[i][2] = mCursor.getString(mCursor
							.getColumnIndex(SqlLiteHelper.COLUMN_BOOKAUTHOR));
					results[i][3] = mCursor.getString(mCursor
							.getColumnIndex(SqlLiteHelper.COLUMN_ISBN));
					results[i][4] = mCursor.getString(mCursor
							.getColumnIndex(SqlLiteHelper.COLUMN_PRICE));

					i = i + 1;
				} while (mCursor.moveToNext());

			}
			// return results;

		} catch (Exception e) {
			// results = new String[1][1];
			System.out.println(e.toString());

		}
		return results;
	}

}
