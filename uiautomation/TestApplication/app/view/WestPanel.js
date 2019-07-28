/*
 * File: app/view/WestPanel.js
 */

Ext.define('TestApp.view.WestPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.westPanel',

    requires: [
        'Ext.tree.Panel'
    ],

    width: 248,
    layout: 'accordion',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'treepanel',
                    title: 'My Panel One',
                    store: 'TreeStore'
                },
                {
                    xtype: 'panel',
                    title: 'My Panel Two'
                }
            ]
        });

        me.callParent(arguments);
    }

});