/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dressrooms.API;

import java.util.ArrayList;

/**
 *
 * @author ivanr
 */
public class Root {

    public int page;
    public int pageSize;
    public int maxPageSize;
    public int pageCount;
    public ArrayList<Result> results;

    public Root(int page, int pageSize, int maxPageSize, int pageCount, ArrayList<Result> results) {
        this.page = page;
        this.pageSize = pageSize;
        this.maxPageSize = maxPageSize;
        this.pageCount = pageCount;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxPageSize() {
        return maxPageSize;
    }

    public void setMaxPageSize(int maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

}
