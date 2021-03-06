package com.example.srdjan.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.srdjan.myapplication.db.model.Actor;
import com.example.srdjan.myapplication.db.model.Movie;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by srdjan on 21.6.17..
 */

public class ORMLightHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME    = "priprema.db";
    private static final int    DATABASE_VERSION = 1;

    private Dao<Movie, Integer> mMovieDao = null;
    private Dao<Actor, Integer> mActorDao = null;

    public ORMLightHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Movie.class);
            TableUtils.createTable(connectionSource, Actor.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Movie.class, true);
            TableUtils.dropTable(connectionSource, Actor.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<Movie, Integer> getMovieDao() throws SQLException {
        if (mMovieDao == null) {
            mMovieDao = getDao(Movie.class);
        }

        return mMovieDao;
    }

    public Dao<Actor, Integer> getActorDao() throws SQLException {
        if (mActorDao == null) {
            mActorDao = getDao(Actor.class);
        }

        return mActorDao;
    }

    //obavezno prilikom zatvarnaj rada sa bazom osloboditi resurse
    @Override
    public void close() {
        mMovieDao = null;
        mActorDao = null;

        super.close();
    }

}
