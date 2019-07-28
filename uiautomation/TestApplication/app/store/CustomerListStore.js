/*
 * File: app/store/CustomerListStore.js
 */

Ext.define('TestApp.store.CustomerListStore', {
    extend: 'Ext.data.Store',

    requires: [
        'TestApp.model.CustomerListModel',
        'Ext.data.proxy.Memory',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'TestApp.model.CustomerListModel',
            storeId: 'CustomerListStore',
            data: [
                {
                    title: 'Test Title One',
                    firstname: 'User One',
                    lastname: 'Last One',
                    age: 28,
                    manufacturer: 'Nissan',
                    hp: true,
                    comments: 'Required Test Drive'
                },
                {
                    title: 'Test Title Two',
                    firstname: 'User Two',
                    lastname: 'Last Two',
                    age: 35,
                    manufacturer: 'BMW',
                    hp: false,
                    comments: 'Something'
                },
                
            ],
            proxy: {
                type: 'memory',
                reader: {
                    type: 'json'
                }
            }
        }, cfg)]);
    }
});