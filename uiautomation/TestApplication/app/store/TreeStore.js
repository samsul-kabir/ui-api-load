/*
 * File: app/store/TreeStore.js
 */

Ext.define('TestApp.store.TreeStore', {
    extend: 'Ext.data.TreeStore',

    requires: [
        'TestApp.model.TreeModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'TestApp.model.TreeModel',
            storeId: 'TreeStore',
            root: {
                expanded: true,
                text: 'Data Hub',
                children: [
                    {
                        text: 'Form',
                        id: 'validationForm',
                        leaf: true
                    },
                    {
                        text: 'Browser Info',
                        id: 'browserInfo',
                        leaf: true
                    }
                ]
            }
        }, cfg)]);
    }
});