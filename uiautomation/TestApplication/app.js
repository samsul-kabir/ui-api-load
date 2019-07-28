/*
 * File: app.js
 */

var credentials = {
    'user': 'test',
	'password': 'test'
}; 

// @require @packageOverrides
Ext.Loader.setConfig({
    enabled: true
});


Ext.application({
    models: [
        'TreeModel',
        'CustomerListModel'
    ],
    stores: [
        'TreeStore',
        'CustomerListStore'
    ],
    views: [
        'Viewport',
        'CenterTabPanel',
        'WestPanel',
        'LoginWindow',
        'ValidationForm',
        'NorthPanel',
        'FilterGridPanel'
    ],
    controllers: [
        'MainController'
    ],
    name: 'TestApp',

    launch: function() { 
        Ext.create('TestApp.view.LoginWindow', {}).show();

    }

});
