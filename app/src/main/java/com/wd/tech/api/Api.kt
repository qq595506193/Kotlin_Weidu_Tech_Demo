package com.wd.tech.api

object Api {

    /**
     * RSA加密
     */
    val RSA_Api = "techApi/tool/v1/encrypt"

    /*
    * 用户模块
    * */
    val register_Api = "techApi/user/v1/register"
    //用户注册
    val login_Api = "techApi/user/v1/login"
    //用户登录
    val perfectUserInfo_Api = "techApi/user/verify/v1/perfectUserInfo"
    //完善用户信息
    val getUserInfoByUserId_Api = "techApi/user/verify/v1/getUserInfoByUserId"
    //根据用户ID查询用户信息
    val modifyNickName_Api = "techApi/user/verify/v1/modifyNickName"
    //修改用户昵称
    val modifySignature_Api = "techApi/user/verify/v1/modifySignature"
    //修改用户昵称
    val modifyHeadPic_Api = "techApi/user/verify/v1/modifyHeadPic"
    //用户上传头像
    val modifyEmail_Api = "techApi/user/verify/v1/modifyEmail"
    //修改邮箱
    val modifyUserPwd_Api = "techApi/user/verify/v1/modifyUserPwd"
    //修改用户密码
    val findConversationList_Api = "techApi/user/verify/v1/findConversationList"
    //根据极光usernames批量查询回话列表需要的用户信息
    val findUserIntegral_Api = "techApi/user/verify/v1/findUserIntegral"
    //查询用户积分
    val findUserIntegralRecord_Api = "techApi/user/verify/v1/findUserIntegralRecord"
    //查询用户积分明细
    val findAllInfoCollection_Api = "techApi/user/verify/v1/findAllInfoCollection"
    //用户收藏列表
    val addCollection_Api = "techApi/user/verify/v1/addCollection"
    //添加收藏
    val cancelCollection_Api = "techApi/user/verify/v1/cancelCollection"
    //取消收藏
    val findFollowUserList_Api = "techApi/user/verify/v1/findFollowUserList"
    //用户关注列表
    val addFollow_Api = "techApi/user/verify/v1/addFollow"
    //关注用户
    val checkPhone_Api = "techApi/user/v1/checkPhone"
    //校验手机号是否可用
    val weChatLogin_Api = "techApi/user/v1/weChatLogin"
    //微信登录
    val bindWeChat_Api = "techApi/user/verify/v1/bindWeChat"
    //绑定微信帐号
    val whetherToBindWeChat_Api = "techApi/user/verify/v1/whetherToBindWeChat"
    //查询用户任务列表
    val doTheTask_Api = "techApi/user/verify/v1/doTheTask"
    //做任务
    val userSign_Api = "techApi/user/verify/v1/userSign"
    //签到
    val findUserSignStatus_Api = "techApi/user/verify/v1/findUserSignStatus"
    //查询当天签到状态
    val findContinuousSignDays_Api = "techApi/user/verify/v1/findContinuousSignDays"
    //查询用户连续签到天数
    val findUserSignRecording_Api = "techApi/user/verify/v1/findUserSignRecording"
    //查询用户当月所有签到的日期
    val queryFriendInformation_Api = "techApi/user/verify/v1/queryFriendInformation"
    //查询好友信息
    val incrementFindFaceFeature_Api = "techApi/user/v1/incrementFindFaceFeature"
    //增量查询脸部特征库
    val bindingFaceId_Api = "techApi/user/verify/v1/bindingFaceId"
    //绑定faceId
    val faceLogin_Api = "techApi/user/v1/faceLogin"
    //刷脸登陆
    val findUserByPhone_Api = "techApi/user/verify/v1/findUserByPhone"
    //根据手机号查询用户信息
    val untiedFaceId_Api = "techApi/user/verify/v1/untiedFaceId"
    //解绑faceId


    /*
    *好友相关接口
     */
    val addFriend_Api = "techApi/chat/verify/v1/addFriend"
    //添加好友
    val deleteFriendRelation_Api = "techApi/chat/verify/v1/deleteFriendRelation"
    //删除好友
    val modifyFriendRemark_Api = "techApi/chat/verify/v1/modifyFriendRemark"
    //修改好友备注
    val checkMyFriend_Api = "techApi/chat/verify/v1/checkMyFriend"
    //检测是否为我的好友
    val addFriendGroup_Api = "techApi/chat/verify/v1/addFriendGroup"
    //创建自定义好友分组
    val findFriendGroupList_Api = "techApi/chat/verify/v1/findFriendGroupList"
    //查询用户所有分组
    val modifyGroupName_Api = "techApi/chat/verify/v1/modifyGroupName"
    //修改好友分组名称
    val transferFriendGroup_Api = "techApi/chat/verify/v1/transferFriendGroup"
    //转移好友到其他分组
    val deleteFriendGroup_Api = "techApi/chat/verify/v1/deleteFriendGroup"
    //删除用户好友分组
    val findFriendListByGroupId_Api = "techApi/chat/verify/v1/findFriendListByGroupId"
    //查询分组下的好友列表信息
    val findFriendNoticePageList_Api = "techApi/chat/verify/v1/findFriendNoticePageList"
    //查询用户的好友通知记录
    val reviewFriendApply_Api = "techApi/chat/verify/v1/reviewFriendApply"
    //审核好友申请
    val sendMessage_Api = "techApi/chat/verify/v1/sendMessage"
    //发送消息
    val findChatRecordPageList_Api = "techApi/chat/verify/v1/findChatRecordPageList"
    //查询好友聊天记录
    val findDialogueRecordPageList_Api = "techApi/chat/verify/v1/findDialogueRecordPageList"
    //查询好友对话记录
    val deleteChatRecord_Api = "techApi/chat/verify/v1/deleteChatRecord"
    //删除好友聊天记录
    val searchFriend_Api = "techApi/chat/verify/v1/searchFriend"
    //查询我的好友列表
    val initFriendList_Api = "techApi/chat/verify/v1/initFriendList"
    //初始化我的好友列表全量信息


    /*
    *群组相关接口
     */


    val createGroup_Api = "techApi/group/verify/v1/createGroup"
    //创建群
    val GroupmodifyGroupName_Api = "techApi/group/verify/v1/modifyGroupName"
    //修改群组名
    val modifyGroupDescription_Api = "techApi/group/verify/v1/modifyGroupDescription"
    //修改群简介
    val disbandGroup_Api = "techApi/group/verify/v1/disbandGroup"
    //解散群组
    val findGroupsByUserId_Api = "techApi/group/verify/v1/findGroupsByUserId"
    //查询我创建的群组
    val findUserJoinedGroup_Api = "techApi/group/verify/v1/findUserJoinedGroup"
    //查询我所有加入的群组
    val findGroupMemberList_Api = "techApi/group/verify/v1/findGroupMemberList"
    //查询群组内所有用户信息
    val findGroupInfo_Api = "techApi/group/verify/v1/findGroupInfo"
    //查询群组详细信息
    val sendGroupMessage_Api = "techApi/group/verify/v1/sendGroupMessage"
    // 发送群信息
    val findGroupChatRecordPage_Api = "techApi/group/verify/v1/findGroupChatRecordPage"
    //查询群聊天内容
    val removeGroupMember_Api = "techApi/group/verify/v1/removeGroupMember"
    //移出群成员(管理员与群主才有的权限)
    val modifyPermission_Api = "techApi/group/verify/v1/modifyPermission"
    //调整群成员角色(群主才有的权限)
    val whetherInGroup_Api = "techApi/group/verify/v1/whetherInGroup"
    //判断用户是否已在群内
    val applyAddGroup_Api = "techApi/group/verify/v1/applyAddGroup"
    //申请进群
    val inviteAddGroup_Api = "techApi/group/verify/v1/inviteAddGroup"
    //上传群头像
    val retreat_Api = "techApi/group/verify/v1/retreat"
    //退群


    /*
    *资讯相关接口
     */
    val bannerShow_Api = "techApi/information/v1/bannerShow"
    //banner展示列表
    val infoRecommendList_Api = "techApi/information/v1/infoRecommendList"
    //资讯推荐展示列表(包含单独板块列表展示)
    val findInformationDetails_Api = "techApi/information/v1/findInformationDetails"
    // 资讯详情展示
    val findAllInfoPlate_Api = "techApi/information/v1/findAllInfoPlate"
    //所有板块查询
    val updateInfoShareNum_Api = "techApi/information/v1/updateInfoShareNum"
    //修改资讯分享数
    val addGreatRecord_Api = "techApi/information/verify/v1/addGreatRecord"
    //资讯点赞
    val cancelGreat_Api = "techApi/information/verify/v1/cancelGreat"
    //取消点赞
    val addInfoComment_Api = "techApi/information/verify/v1/addInfoComment"
    //资讯用户评论
    val findAllInfoCommentList_Api = "techApi/information/v1/findAllInfoCommentList"
    //查询资讯评论列表
    val findInformationByTitle_Api = "techApi/information/v1/findInformationByTitle"
    //根据标题模糊查询
    val findInformationBySource_Api = "techApi/information/v1/findInformationBySource"
    //根据作者名模糊查询
    val findInfoAdvertising_Api = "techApi/information/v1/findInfoAdvertising"
    //资讯广告
    val infoPayByIntegral = "techApi/information/verify/v1/infoPayByIntegral"
    //资讯积分兑换


    /*
    *社区相关接口
     */

    val findCommunityList_Api = "techApi/community/v1/findCommunityList"
    //社区列表
    val releasePost_Api = "techApi/community/verify/v1/releasePost"
    //发布帖子
    val deletePost_Api = "techApi/community/verify/v1/deletePost"
    //删除帖子(支持批量删除)
    val addCommunityGreat_Api = "techApi/community/verify/v1/addCommunityGreat"
    //点赞
    val cancelCommunityGreat_Api = "techApi/community/verify/v1/cancelCommunityGreat"
    //取消点赞
    val findCommunityCommentList_Api = "techApi/community/v1/findCommunityCommentList"
    //社区评论列表（标签方式返参）
    val findCommunityUserCommentList_Api = "techApi/community/v1/findCommunityUserCommentList"
    //社区用户评论列表（bean方式返参）
    val addCommunityComment_Api = "techApi/community/verify/v1/addCommunityComment"
    //社区评论
    val findMyPostById_Api = "techApi/community/verify/v1/findMyPostById"
    // 我的帖子
    val findUserPostById_Api = "techApi/community/verify/v1/findUserPostById"
    // 查询用户发布的帖子


    /*
    *综合业务相关接口
     */
    val findVipCommodityList_Api = "techApi/tool/v1/findVipCommodityList"
    //查询所有会员商品
    val buyVip_Api = "techApi/tool/verify/v1/buyVip"
    //用户购买VIP
    val pay_Api = "techApi/tool/verify/v1/pay"
    //支付
    val wxShare_Api = "techApi/tool/v1/wxShare"
    //微信分享前置接口，获取分享所需参数
    val recordFeedBack_Api = "techApi/tool/verify/v1/recordFeedBack"
    //意见反馈
    val findNewVersion_Api = "techApi/tool/v1/findNewVersion"
    //查询新版本
    val findAllPrize_Api = "techApi/tool/verify/v1/findAllPrize"
    //查询所有奖品
    val lottery_Api = "techApi/tool/verify/v1/lottery"
    //抽奖
    val findLotteryRecordLis_Apit = "techApi/tool/verify/v1/findLotteryRecordList"
    //查询用户抽奖记录
    val receivePrize_Api = "techApi/tool/verify/v1/receivePrize"
    //领取奖品
    val findSysNoticeList_Api = "techApi/tool/verify/v1/findSysNoticeList"
    //查询用户系统通知
}
