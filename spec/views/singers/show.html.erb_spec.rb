require 'spec_helper'

describe "singers/show" do
  before(:each) do
    @singer = assign(:singer, stub_model(Singer))
  end

  it "renders attributes in <p>" do
    render
    # Run the generator again with the --webrat flag if you want to use webrat matchers
  end
end
