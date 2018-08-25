app.controller('brandController', function ($scope, brandService) {
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };
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

    $scope.findPage = function (page, rows) {
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
                $scope.select_all = false;
            }
        );
    };
    //增加
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id) {
            object = brandService.update($scope.entity);
        } else {
            object = brandService.add($scope.entity);
        }
        object.success(function (response) {
            if (response.success) {
                $scope.reloadList();
            } else {
                alert(response.message)
            }
        })
    };
    //修改
    $scope.findOne = function (id) {

        brandService.findOne(id).success(function (res) {
            $scope.entity = res;
        })
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
        }

    };
    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                }
            }
        );
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
    $scope.searchs = {};//定义搜索对象
    $scope.search = function (page, rows) {
        brandService.search(page,rows,$scope.searchs).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;//总记录数
                $scope.list = response.rows;//给列表变量赋值
            }
        );
    }
});