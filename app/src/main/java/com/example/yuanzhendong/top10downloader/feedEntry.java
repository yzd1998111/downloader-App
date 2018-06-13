package com.example.yuanzhendong.top10downloader;

public class feedEntry {
    private String name;
    private String artist;
    private String releaseData;
    private String imageUrl;
    private String summary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "name" + name + "\n" + "artist:" + artist + "\n" + "releaseDate=" + releaseData + "\n" + "iamgeUrl" + imageUrl + "\n";
    }
}
