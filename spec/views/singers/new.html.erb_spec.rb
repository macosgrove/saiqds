require 'spec_helper'

describe "singers/new" do
  before(:each) do
    assign(:singer, stub_model(Singer).as_new_record)
  end

  it "renders new singer form" do
    render

    # Run the generator again with the --webrat flag if you want to use webrat matchers
    assert_select "form", :action => singers_path, :method => "post" do
    end
  end
end
