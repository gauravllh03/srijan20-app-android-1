package in.srijanju.androidapp.controller;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

import in.srijanju.androidapp.R;
import in.srijanju.androidapp.model.SrijanEvent;

public class EventAdapter extends BaseAdapter {

	private Activity context;
	private ArrayList<SrijanEvent> events;

	public EventAdapter(Activity context, ArrayList<SrijanEvent> list) {
		this.context = context;
		events = list;
	}

	@Override
	public int getCount() {
		return events.size();
	}

	@Override
	public Object getItem(int position) {
		return events.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View v;
		if (convertView == null) {
			v = inflater.inflate(R.layout.icon_event, null, true);
		} else {
			v = convertView;
		}
		TextView eventName = v.findViewById(R.id.tv_event_name);
		TextView eventType = v.findViewById(R.id.tv_event_type);
		final ImageView ivEvent = v.findViewById(R.id.iv_event_icon_back);

		String poster = events.get(position).poster;
		if (poster == null || poster.equals(""))
			poster = "https://image.freepik.com/free-photo/gray-painted-background_53876-94041.jpg";

		Glide.with(context).asBitmap().load(poster).into(
			new CustomTarget<Bitmap>() {
				@Override
				public void onResourceReady(
					@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
					ivEvent.setImageBitmap(resource);
				}

				@Override
				public void onLoadCleared(
					@Nullable Drawable placeholder) {

				}
			});

		eventName.setText(events.get(position).name);
		eventType.setText(events.get(position).type);

		return v;
	}
}