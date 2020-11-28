//函数对象
const App = function () {
    /**
     * 私有全局属性
     */
    let _icheck_control;
    let _icheck_list;
    /**
     * 存放选中 box id 的数组
     */
    let _idArray;
    /**
     *  私有方法
     */
    const handlerInitCheckBox = function () {
        //激活 iCheck
        $('input[type="checkbox"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        _icheck_control = $('input[type="checkbox"].icheck_control');
        _icheck_list = $('input[type="checkbox"].minimal');
    };
    /**
     * checkBox 全选功能
     */
    const handlerCheckAllBox = function () {
        //绑定点击事件，获取选中状态
        _icheck_control.on("ifClicked", function (e) {
            //控制端未选中
            if (e.target.checked) {
                _icheck_list.iCheck("uncheck");
            }
            //控制端已选中
            else {
                _icheck_list.iCheck("check");
            }
        });
    };
    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();
        //删除单项
        const deleteUrl = url.split("/user/delete?id=");
        //获取删除项 id
        const _id_delete = parseInt(deleteUrl[1]);
        //单项删除
        if(!isNaN(_id_delete)){
            _idArray.push(_id_delete)
        }
        //批量删除
        else {
            //将选中元素的 id 放入数组中
            _icheck_list.each(function () {
                const _id = $(this).attr("id");
                if (_id != null && _id != "undefine" && $(this).is(":checked"))
                    _idArray.push(_id);
            });
        }

        //判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        } else {
            $("#modal-message").html("您确定删除数据项吗？");
        }
        //点击删除按钮时弹出模态框
        $("#modal-default").modal("show");
        //如果用户选择了数据项则调用删除方法
        $("#btnModalOk").bind("click", function () {
            del();
        });

        /**
         * 当前私有函数的私有函数
         */
        function del() {
            $("#modal-default").modal("hide");
            //如果没有选择数据项的处理
            if (_idArray.length === 0) {
                //...
                // $("#modal-default").modal("hide");
            }
            //删除操作
            else {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        //请求成功后，无论成功还是失败都需要弹出模态框进行提示,所以这里需要先解绑原来的 click 事件
                        $("#btnModalOk").unbind("click");
                        //请求成功
                        if (data.status === 200) {
                            //刷新页面
                            $("#btnModalOk").bind("click", function () {
                                window.location.reload();
                            });

                        }
                        //请求失败
                        else {
                            //确定按钮的事件改为隐藏模态框
                            $("#btnModalOk").bind("click", function () {
                                $("#modal-default").modal("hide");
                                window.location.reload();
                            });

                        }
                        //因为无论如何都需要提示信息，所以这里的模态框必须调用的
                        $("#modal-message").html(data.message);
                        $("#modal-default").modal("show");
                    }
                });
            }
        }
    };

    /**
     * 查看详情
     * @param url
     */
    const handlerShowDetail = function (url) {
        //这里是通过 Ajax 请求 html 的方式将 jsp 装在进模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };
    //默认的 Dropzone 参数
    const defaultDropzoneOpts = {
        url: "",
        dictDefaultMessage: '拖动文件至此或者点击上传', //设置默认的提示语句
        paramName: "dropFile",
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        //previewsContainer:"#preview", // 上传图片的预览窗口
        dictMaxFilesExceeded: "您最多只能上传" + this.maxFiles + "个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消",
    };
    /**
     * 激活 Dropzone
     * @param elementId
     * @param url
     */
    const handlerDropZone = function (opts) {
        //关闭 dropzone 的自动发现功能
        Dropzone.autoDiscover = false;
        $.extend(defaultDropzoneOpts, opts);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);

    };
    /**
     * 初始化 DataTable
     * @param url
     * @param columns
     */
    const handlerInitDataTable = function (url,columns) {
      const _dataTable =   $('#dataTable').DataTable({
            'paging'      : true,
            'ordering'    : false,
            'info'        : true,
            'autoWidth'   : false,
            "searching": false,
            "lengthChange": false,
            "processing": true,
            "language":{
                "sProcessing":   "处理中...",
                "sLengthMenu":   "显示 _MENU_ 项结果",
                "sZeroRecords":  "没有匹配结果",
                "sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix":  "",
                "sSearch":       "搜索:",
                "sUrl":          "",
                "sEmptyTable":     "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands":  ",",
                "oPaginate": {
                    "sFirst":    "首页",
                    "sPrevious": "上页",
                    "sNext":     "下页",
                    "sLast":     "末页"
                },
                "oAria": {
                    "sSortAscending":  ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            serverSide: true,
            ajax: {
                "url": url,
            },
            "columns": columns,
            "drawCallback": function( settings ) {
                handlerInitCheckBox();
                handlerCheckAllBox();
            }
        });
      return _dataTable;
    };
    /**
     * 初始化 zTree
     * @param url
     * @param autoParam
     * @param callback
     */
    const handlerInitZTree = function (url, autoParam, callback) {
        const setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam
            }
        };
        $.fn.zTree.init($("#myTree"), setting);
        $("#btnModalOk").bind("click", function () {
            const zTree = $.fn.zTree.getZTreeObj("myTree");
            const nodes = zTree.getSelectedNodes();

            //未选择
            if (nodes.length == 0) {
                alert("请先选择一个节点");
            }
            //已选择
            else {
                callback(nodes);
            }
        });
    };
    //将私有方法暴露给外界调用
    return {
        /**
         * 初始化 checkBox
         */
        initCheckBox: function () {
            handlerInitCheckBox();
            handlerCheckAllBox();
        },
        /**
         * 初始化 zTree
         */
        initZTree: function (url,autoParam,callback) {
            handlerInitZTree(url,autoParam,callback);
        },
        /**
         * 初始化 Dropzone
         * @param opts
         */
        initDropzone: function (opts) {
            handlerDropZone(opts)
        },
        /**
         * 批量删除
         */
        handlerDeleteMulti: function (url) {
            handlerDeleteMulti(url);
        },
        handlerDataTable: function (url,columns){
            return handlerInitDataTable(url,columns);
        },
        handlerShowDetail: function (url) {
            handlerShowDetail(url);
        },

    }
}();
/**
 * 当 js 被导入时就初始化 iCheckBox
 */
$(document).ready(function () {
    App.initCheckBox();
})