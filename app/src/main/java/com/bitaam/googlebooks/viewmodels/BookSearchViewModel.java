package com.bitaam.googlebooks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bitaam.googlebooks.R;
import com.bitaam.googlebooks.modals.VolumesResponse;
import com.bitaam.googlebooks.repository.BookRepository;

import io.github.cdimascio.dotenv.Dotenv;

public class BookSearchViewModel extends AndroidViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword, String author) {
//        Dotenv dotenv = Dotenv.configure().directory("/assets").filename("env").load();
        bookRepository.searchVolumes(keyword, author, getApplication().getString(R.string.GOOGLE_API_KEY));
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}