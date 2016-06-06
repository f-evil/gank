package com.fyj.gank.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fyj.gank.R;
import com.fyj.dependlib.mock.DummyContent;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DummyContent.DummyItem> mValues;
    private boolean mIsStagger;

    public MyItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
        mValues = items;
    }

    public void switchMode(boolean mIsStagger) {
        this.mIsStagger = mIsStagger;
    }

    public void setData(List<DummyContent.DummyItem> datas) {
        mValues = datas;
    }

    public void addDatas(List<DummyContent.DummyItem> datas) {
        mValues.addAll(datas);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item, parent, false);
            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder mHolder = (ViewHolder) holder;
            mHolder.mItem = mValues.get(position);
            mHolder.mContentView.setText(mValues.get(position).content);
            mHolder.mIdView.setText(mValues.get(position).id);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class StaggerViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public View iconView;
        public TextView mContentView;

        public StaggerViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            iconView = itemView.findViewById(R.id.icon);
            mContentView = (TextView) itemView.findViewById(R.id.content);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyContent.DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
