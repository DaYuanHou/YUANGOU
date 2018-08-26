app.controller('controller', function ($scope, brandService,$controller) {

    $controller('baseController',{$scope:$scope});

    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    };
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
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

    $scope.dele = function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                }
            }
        );
    };
    $scope.searchs = {};//定义搜索对象
    $scope.search = function (page, rows) {
        brandService.search(page, rows, $scope.searchs).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;//总记录数
                $scope.list = response.rows;//给列表变量赋值
            }
        );
    }
});