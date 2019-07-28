/*
 * File: app/view/Viewport.js
 */

Ext.define('TestApp.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'TestApp.view.CenterTabPanel',
        'TestApp.view.WestPanel',
        'TestApp.view.NorthPanel',
        'Ext.tab.Panel'
    ],

    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'centerTabPanel',
                    region: 'center'
                },
                {
                    xtype: 'westPanel',
                    region: 'west'
                },
                {
                    xtype: 'northpanel',
                    region: 'north',
                    height: 24
                }
            ]
        });

        me.callParent(arguments);
    }

});