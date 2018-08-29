app.controller('baseController', function ($scope) {
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };

    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    $scope.selectIds = [];
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {//如果是被选中,则增加到数组
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
            angular.forEach($scope.list, function (i) {
                i.checked = false;
            });
            $scope.selectIds = [];
            $scope.select_all = false;
            //属性的过滤,取消全选的时候，将这个属性变成false
            angular.forEach($scope.entity.customAttributeItems, function (i) {
                i.checked = false;
                $scope.selectIds = [];
            })
        }
    };
    $scope.selectAll = function ($event) {
        if ($event.target.checked) {
            $scope.checked = [];
            angular.forEach($scope.list, function (i) {
                i.checked = true;
                $scope.selectIds.push(i.id);
            })
        } else {
            angular.forEach($scope.list, function (i) {
                i.checked = false;
                $scope.selectIds = [];
            })
        }
    };
    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);//将json字符串转换为json对象
        var value = "";
        for (var i = 0; i < json.length; i++) {
            if (i > 0) {
                value += ","
            }
            value += json[i][key];
        }
        return value;
    }
});