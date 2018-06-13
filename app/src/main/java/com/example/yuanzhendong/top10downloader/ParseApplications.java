package com.example.yuanzhendong.top10downloader;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseApplications {
    private static final String TAG = "parseApplication";
    private ArrayList<feedEntry> applications;

    public ParseApplications() {
        this.applications = new ArrayList<>();
    }

    public ArrayList<feedEntry> getApplications() {
        return applications;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        feedEntry currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("entry".equalsIgnoreCase(tagName)) {
                            inEntry = true;
                            currentRecord = new feedEntry();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntry) {
                            if ("entry".equalsIgnoreCase(tagName)) {
                                Log.d(TAG, "entry");
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if ("name".equalsIgnoreCase(tagName)) {
                                Log.d(TAG, "name" + textValue);
                                currentRecord.setName(textValue);
                            } else if ("artist".equalsIgnoreCase(tagName)) {
                                Log.d(TAG, "artist" + textValue);
                                currentRecord.setArtist(textValue);
                            } else if ("summary".equalsIgnoreCase(tagName)) {
                                Log.d(TAG, "summary" + textValue);
                                currentRecord.setSummary(textValue);
                            } else if ("releaseDate".equalsIgnoreCase(tagName)) {
                                Log.d(TAG, "releaseDate" + textValue);
                                currentRecord.setReleaseData(textValue);
                            } else if ("image".equalsIgnoreCase(tagName)) {
                                Log.d(TAG, "image" + textValue);
                                currentRecord.setImageUrl(textValue);
                            }
                        }
                        break;
                    default:


                }
                eventType = xpp.next();
            }
            for (feedEntry app : applications) {
                Log.d(TAG, app.toString());
            }

        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}
