const gzzrAjax = {
    ajaxGet: function (url,data,callback) {
        $.ajax({
            url:url,
            type:"get",
            contentType:"application/json",
            dataType:"json",
            timeout:10000,
            data:data,
            success:function(data){
                callback(data);
            },
            error:function(xhr,textstatus,thrown){
                console.log("Get Fail!");
            }
        });
    },
    ajaxPost: function (url,data,callback) {
        $.ajax({
            url:url,
            type:"post",
            contentType:"application/json",
            dataType:"json",
            timeout:10000,
            data:data,
            success:function(data){
                callback(data);
            },
            error:function(xhr,textstatus,thrown){
                console.log("Post Fail!");
            }
        });
    },
    ajaxPut: function (url,data,callback) {
        $.ajax({
            url:url,
            type:"put",
            contentType:"application/json",
            dataType:"json",
            timeout:10000,
            data:data,
            success:function(data){
                callback(data);
            },
            error:function(xhr,textstatus,thrown){
                console.log("Put Fail!");
            }
        });
    },
    ajaxDelete: function (url,data,callback) {
        $.ajax({
            url:url,
            type:"delete",
            contentType:"application/json",
            dataType:"json",
            timeout:10000,
            data:data,
            success:function(data){
                callback(data);
            },
            error:function(xhr,textstatus,thrown){
                console.log("Delete Fail!");
            }
        });
    }
};
