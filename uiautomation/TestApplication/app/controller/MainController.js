/*
 * File: app/controller/MainController.js
 */

Ext.define('TestApp.controller.MainController', {
    extend: 'Ext.app.Controller',

	/**
	 * Handles treepanel item click
	 *
	 * Adds a tab to the tabpanel
	 *
	 * @param	{object}		dataview	Treeview
	 * @param	{object}		record		Selected record
	 * @param	{DOMElement}	item		Selected dom element
	 * @param	{int}			index		Index of selected node
	 * @param	{object}		e			Event object
	 * @param	{object}		eOpts		Additional config
	 */
    onTreepanelItemClick: function(dataview, record, item, index, e, eOpts) {
        var me = this,
        	centerTabPanel = Ext.ComponentQuery.query("centerTabPanel")[0];

         switch (record.data.id) {
                    case 'browserInfo':
                      var browserInfoPanel = centerTabPanel.query('browserInfoPanel')[0];
                      if (browserInfoPanel === undefined) {
                          var browserInfoPanel = Ext.create('TestApp.view.FilterGridPanel', {});
                          createTabPanel(browserInfoPanel);
                      }else{
                             centerTabPanel.setActiveTab(browserInfoPanel);
                      }
                      updateInfo(e);
                      break;

                    case 'validationForm':
                      var validationForm = centerTabPanel.query('validationForm')[0];
                      if (validationForm === undefined) {
                          var validationForm = Ext.create('TestApp.view.ValidationForm', {});
                          createTabPanel(validationForm);
                      }else{
                             centerTabPanel.setActiveTab(validationForm);
                      }
                      updateInfo(e);
                      break;
         }


        function createTabPanel(oPanel){
            var cntrTabPanel = Ext.ComponentQuery.query("centerTabPanel")[0];
            Ext.defer(function() {
                cntrTabPanel.add(oPanel);
                cntrTabPanel.setActiveTab(oPanel);
            }, 400);
        }

        function updateInfo(e){
            var northpanel = Ext.ComponentQuery.query("northpanel")[0],
                selNodeDisplayField = northpanel.down('#selectedNode'),
                nodeRawText = e.target.innerText;

            selNodeDisplayField.setValue('<b>' + nodeRawText + '</b>');
        }
    },

	/**
	 * Handles form button click
	 *
	 * Save form content to grid
	 * Load grid content to form
	 * Reset form content
	 *
	 * @param	{object}		button		Button
	 * @param	{object}		e			Event object
	 * @param	{object}		eOpts		Additional config
	 */
    onFormButtonClick: function(button, e, eOpts) {
        var form = button.up('form').getForm();

        switch(button.action){
            case 'saveCustomerInfo':
                if (form.isValid()) {
                    var store = button.up('form').down('grid').store,
                        data = form.getValues();
                    store.insert(0, data);
                    form.reset();
                }
                break;

            case 'loadCustomerInfo':
                var grid = button.up('form').down('grid'),
                    selectedRecord = grid.getSelectionModel().getSelection();
                form.loadRecord(selectedRecord[0]);
                break;

            case 'resetCustomerInfo':
                form.reset();
                break;

        }
    },

    init: function(application) {
        this.control({
            "westPanel treepanel": {
                itemclick: this.onTreepanelItemClick
            },
            "validationForm button": {
                click: this.onFormButtonClick
            }
        });
    }

});
