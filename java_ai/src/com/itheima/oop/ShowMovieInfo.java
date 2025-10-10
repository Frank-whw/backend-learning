package com.itheima.oop;

public class ShowMovieInfo {
    public static void main(String[] args) {
        Movie[] movies = {
                new Movie(1, "星际穿越", 45.0, "马修·麦康纳"),
                new Movie(2, "盗梦空间", 42.5, "莱昂纳多·迪卡普里奥"),
                new Movie(3, "阿甘正传", 39.9, "汤姆·汉克斯"),
                new Movie(4, "泰坦尼克号", 40.0, "莱昂纳多·迪卡普里奥"),
                new Movie(5, "肖申克的救赎", 38.5, "蒂姆·罗宾斯"),
                new Movie(6, "楚门的世界", 37.0, "金·凯瑞")
        };

        MovieOperator mo = new MovieOperator(movies);
        mo.printAllMovies();
        mo.searchMovieById();

    }
}
