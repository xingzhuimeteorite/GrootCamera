package com.example.grootcamera

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import com.jiangdg.ausbc.base.CameraFragment
import com.jiangdg.ausbc.widget.AspectRatioTextureView
import com.jiangdg.ausbc.widget.IAspectRatio
import com.example.grootcamera.databinding.FragmentMainBinding
import com.jiangdg.ausbc.MultiCameraClient
import com.jiangdg.ausbc.callback.ICameraStateCallBack
import com.jiangdg.ausbc.camera.bean.CameraRequest
import com.jiangdg.ausbc.render.env.RotateType

class MainFragment : CameraFragment() {
    private lateinit var mViewBinding: FragmentMainBinding
    
    override fun initView() {
        super.initView()

        // 这里可以添加日志来验证视图初始化
        android.util.Log.d("MainFragment", "initView called")
        Toast.makeText(requireContext(), "视图初始化完成", Toast.LENGTH_SHORT).show()
    }
    
    override fun initData() {
        // 设置基本的相机请求参数
        super.initData()
        
        // 创建相机请求，设置旋转角度为90度
        CameraRequest.Builder()

        
        // 应用相机请求

    }

    override fun getCameraView(): IAspectRatio {
        // 创建一个AspectRatioTextureView并设置其宽高比为16:9（横屏显示）
        val cameraView = AspectRatioTextureView(requireContext())
        cameraView.setAspectRatio(3, 2)
        return cameraView
    }
    
    override fun getCameraViewContainer(): ViewGroup {
        return mViewBinding.cameraViewContainer
    }

    override fun getRootView(inflater: LayoutInflater, container: ViewGroup?): View {
        mViewBinding = FragmentMainBinding.inflate(inflater, container, false)
        return mViewBinding.root
    }

    override fun getGravity(): Int = Gravity.CENTER

    // 可选：添加相机状态回调
    override fun onCameraState(self: MultiCameraClient.ICamera, code: ICameraStateCallBack.State, msg: String?) {
        when (code) {
            ICameraStateCallBack.State.OPENED -> Toast.makeText(context, "相机已打开", Toast.LENGTH_SHORT).show()
            ICameraStateCallBack.State.CLOSED -> Toast.makeText(context, "相机已关闭", Toast.LENGTH_SHORT).show()
            ICameraStateCallBack.State.ERROR -> Toast.makeText(context, "相机错误: $msg", Toast.LENGTH_SHORT).show()
        }
    }
}